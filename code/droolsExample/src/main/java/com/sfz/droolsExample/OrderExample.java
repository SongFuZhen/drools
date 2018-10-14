package com.sfz.droolsExample;

import com.sfz.droolsExample.entity.Order;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.math.BigDecimal;

/**
 * @author sfz
 * @date Created at 2018/10/14 17:56
 * @Description
 */
public class OrderExample {
    static KieSession getSession() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();

        return kieContainer.newKieSession("orderRuleKS");
    }


    public static void run() {
        KieSession kieSession = getSession();

        for (int i = 0; i < 2000; i++) {
            Order order = new Order(Long.valueOf(i), "Order_201810140000" + (i + 1), BigDecimal.valueOf(Math.random() * 1000));

            System.out.println("before " + (i + 1) + ":" + order.toString());

            kieSession.insert(order);
        }

        int count = kieSession.fireAllRules();

        System.out.println("--------------------------------总共执行了" + count + "条规则---------------------------------------------");

        kieSession.dispose();
    }


    public static void main(String[] args) {
        run();
    }
}
