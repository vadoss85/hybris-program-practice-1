import javaCode.console.example.AbstractConsoleExample;
import javaCode.console.example.ConsolePrinter;
import javaCode.console.printer.Printer;
import javaCode.se.lambdaExpressions.BuiltInFunctionalInterfacesConsoleExample;
import javaCode.se.lambdaExpressions.FunctionalInterfacesAndLambdasConsoleExample;
import javaCode.se.lambdaExpressions.PractiseWithLambdasConsoleExample;
import javaCode.se.lambdaExpressions.StreamsConsoleExample;

public class LambdaExpressions {
    public static void main(String[] args) {
        ConsolePrinter printer = new Printer();
        AbstractConsoleExample functionalInterface = new FunctionalInterfacesAndLambdasConsoleExample(printer);
        AbstractConsoleExample practiseLambdas = new PractiseWithLambdasConsoleExample(printer);
        AbstractConsoleExample builtInInterfaces = new BuiltInFunctionalInterfacesConsoleExample(printer);
        AbstractConsoleExample streams = new StreamsConsoleExample(printer);

        functionalInterface.printout();
        practiseLambdas.printout();
        builtInInterfaces.printout();
        streams.printout();
    }
}
