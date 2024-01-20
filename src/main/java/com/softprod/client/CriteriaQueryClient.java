package com.softprod.client;

import com.softprod.entities.Specialization;
import com.softprod.entities.Student;
import com.softprod.utils.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import java.util.Arrays;
import java.util.List;

public class CriteriaQueryClient {

    public static void main(String[] args) {
        //createSpecializationAndStudent();
        executeCriteriaQueries();
    }

    private static void createSpecializationAndStudent() {
        EntityManager entityManager = Persistence.createEntityManagerFactory("Test").createEntityManager();
        entityManager.getTransaction().begin();

        Specialization it = new Specialization("IT", 40);
        Specialization analyst = new Specialization("Analyst", 60);
        Student yulia = new Student("Yulia", it);
        Student katya = new Student("Katya", analyst);

        entityManager.persist(yulia);
        entityManager.persist(katya);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    private static void executeCriteriaQueries() {
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        //1
        System.out.println("Criteria Query №1");
        CriteriaQuery<Student> studentCriteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> studentRoot = studentCriteriaQuery.from(Student.class);

        studentCriteriaQuery
                .select(studentRoot)
                .where(criteriaBuilder.equal(studentRoot.get("specialization").get("name"), "IT"));

        List<Student> students = entityManager.createQuery(studentCriteriaQuery).getResultList();
        students.forEach(System.out::println);

        //2
        System.out.println("Criteria Query №2");
        CriteriaUpdate<Specialization> specializationCriteriaUpdate = criteriaBuilder.createCriteriaUpdate(Specialization.class);
        Root<Specialization> specializationRootToUpdate = specializationCriteriaUpdate.from(Specialization.class);

        specializationCriteriaUpdate.set("name", "Designer");
        specializationCriteriaUpdate.where(criteriaBuilder.equal(specializationRootToUpdate.get("id"), 4L));

        entityManager.createQuery(specializationCriteriaUpdate).executeUpdate();

        CriteriaQuery<String> specializationCriteriaQueryById = criteriaBuilder.createQuery(String.class);
        Root<Specialization> specializationRoot = specializationCriteriaQueryById.from(Specialization.class);

        specializationCriteriaQueryById
                .select(specializationRoot.get("name"))
                .where(criteriaBuilder.equal(specializationRoot.get("id"), 4L));

        List<String> specializations3 = entityManager.createQuery(specializationCriteriaQueryById).getResultList();
        specializations3.forEach(System.out::println);

        //3
        System.out.println("Criteria Query №3");
        CriteriaQuery<Object[]> specializationCriteriaQuery = criteriaBuilder.createQuery(Object[].class);
        Root<Specialization> specializationRoot1 = specializationCriteriaQuery.from(Specialization.class);

        specializationCriteriaQuery.multiselect(specializationRoot1.get("name"), specializationRoot1.get("disciplineCount"));

        List<Object[]> specializations4 = entityManager.createQuery(specializationCriteriaQuery).getResultList();
        specializations4.forEach(item -> System.out.println(Arrays.toString(item)));

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
