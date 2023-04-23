package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     *      1. access modifier - optional, followed by space: ' '
     *      2. return type - followed by space: ' '
     *      3. method name
     *      4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     *      private void log(String value)
     *      Vector3 distort(int x, int y, int z, float magnitude)
     *      public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {
        MethodSignature ms;
        int argStart = signatureString.indexOf('(');
        List<MethodSignature.Argument> argumentList = getArguments(signatureString.substring(argStart+1, signatureString.length()-1));

        String[] otherSignature = signatureString.substring(0, argStart).split(" ");

        if(otherSignature.length == 3) {
            ms = new MethodSignature(otherSignature[2], argumentList);
            ms.setAccessModifier(otherSignature[0]);
            ms.setReturnType(otherSignature[1]);
        } else {
            ms = new MethodSignature(otherSignature[1], argumentList);
            ms.setReturnType(otherSignature[0]);
        }

        return ms;
    }

    private List<MethodSignature.Argument> getArguments(String argString) {
        List<MethodSignature.Argument> args = new ArrayList<>();

        if(argString.equals("")) return args;

        String[] argStr = argString.split(", ");
        for(String arg: argStr) {
            String[] argumentSignature = arg.split(" ");
            args.add(new MethodSignature.Argument(argumentSignature[0], argumentSignature[1]));
        }

        return args;
    }
}
