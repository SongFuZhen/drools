package com.sfz.droolsExample;

import com.sfz.droolsExample.entity.Person;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @author sfz
 * @date Created at 2018/10/14 17:56
 * @Description
 */
public class PersonExample {

    static KieSession getSession() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();

        return kieContainer.newKieSession("baseRuleKS");
    }

    public static void run() {
        KieSession kieSession = getSession();

        Person p1 = new Person("P1", 68);
        Person p2 = new Person("P2", 32);
        Person p3 = new Person("P3", 18);
        Person p4 = new Person("P4", 8);
        Person p5 = new Person("P5", 66);

        System.out.println("before p1 : " + p1);
        System.out.println("before p2 : " + p2);
        System.out.println("before p3 : " + p3);
        System.out.println("before p4 : " + p4);
        kieSession.insert(p1);
        kieSession.insert(p2);
        kieSession.insert(p3);
        kieSession.insert(p4);
        kieSession.insert(p5);

        int count = kieSession.fireAllRules();

        System.out.println("总执行了" + count + "条规则------------------------------");

        System.out.println("after p1 : " + p1);
        System.out.println("after p2 : " + p2);
        System.out.println("after p3 : " + p3);
        System.out.println("after p4 : " + p4);
        System.out.println("after p4 : " + p5);
        kieSession.dispose();

        kieSession.dispose();
    }


    public static void main(String[] args) {
        run();
    }
}
