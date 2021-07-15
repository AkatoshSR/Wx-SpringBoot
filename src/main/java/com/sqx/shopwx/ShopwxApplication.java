package com.sqx.shopwx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sqx.shopwx.mapper")
public class ShopwxApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopwxApplication.class, args);
        System.out.println(" ________  ___  ___  ________  ________  _______   ________   ________      \n" +
                "|\\   ____\\|\\  \\|\\  \\|\\   ____\\|\\   ____\\|\\  ___ \\ |\\   ____\\ |\\   ____\\     \n" +
                "\\ \\  \\___|\\ \\  \\\\\\  \\ \\  \\___|\\ \\  \\___|\\ \\   __/|\\ \\  \\___|_\\ \\  \\___|_    \n" +
                " \\ \\_____  \\ \\  \\\\\\  \\ \\  \\    \\ \\  \\    \\ \\  \\_|/_\\ \\_____  \\\\ \\_____  \\   \n" +
                "  \\|____|\\  \\ \\  \\\\\\  \\ \\  \\____\\ \\  \\____\\ \\  \\_|\\ \\|____|\\  \\\\|____|\\  \\  \n" +
                "    ____\\_\\  \\ \\_______\\ \\_______\\ \\_______\\ \\_______\\____\\_\\  \\ ____\\_\\  \\ \n" +
                "   |\\_________\\|_______|\\|_______|\\|_______|\\|_______|\\_________\\\\_________\\\n" +
                "   \\|_________|                                      \\|_________\\|_________|\n  \n");
    }

}
