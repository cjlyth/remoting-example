package com.cjlyth.remoting.example.client;

import org.springframework.boot.ExitCodeGenerator;
/**
 * Created by cjlyth on 7/28/16.
 */

public class ExitException extends RuntimeException implements ExitCodeGenerator {

    @Override
    public int getExitCode() {
        return 10;
    }

}