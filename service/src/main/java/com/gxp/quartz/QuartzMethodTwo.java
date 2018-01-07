package com.gxp.quartz;

import java.util.Date;

public class QuartzMethodTwo {
    private static int counter = 0;

    public void execute() {
        System.out.println("-----------QuartzMethodTwo");
        //下面是业务的具体实现
        long ms = System.currentTimeMillis();
        System.out.println("\t\t" + new Date(ms));
        System.out.println(ms);
        System.out.println("(" + counter++ + ")");
        System.out.println("-----------QuartzMethodTwo");
    }
}
