package com.shaunscaling.lambdatest;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

import java.util.Objects;

public class StringHandler {
    public int countHandler(String word, Context context) {
        LambdaLogger logger = context.getLogger();
        logger.log("received : " + word);
        return Objects.isNull(word) ? -1 : word.length();
    }
}
