package command;

import org.example.command.Command;
import org.example.command.embedded.GrepCommand;
import org.example.execution.Executor;
import org.example.execution.context.Context;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import util.ConsoleCommandRunner;
import util.MockOutputStream;

import java.io.File;
import java.util.List;
import java.util.stream.Stream;

public class GrepCommandTest {

//    @ParameterizedTest
//    @MethodSource("provideTestParameters")
//    void test_runner(String argsAndFlags, int expectedExitCode) throws Exception {
//        try (MockOutputStream mockOutputStream = new MockOutputStream()) {
//            String[] argsAndFlagsList = argsAndFlags.split(" ");
//            Command command = new GrepCommand(List.of(argsAndFlagsList), List.of());
//            Context context = new Context();
//
//            Executor executor = new Executor();
//            int code = executor.executeProcess(command, context);
//
//            assert (code == expectedExitCode);
//            if (expectedExitCode == 0) {
//                String correctOutput = ConsoleCommandRunner.call("grep " + argsAndFlags);
//                assert correctOutput != null;
//                mockOutputStream.ensureEquals(correctOutput);
//            }
//        }
//    }
//
//    private static Stream<Arguments> provideTestParameters() {
//        File folder = new File("build/resources/test");
//        File[] listOfFiles = folder.listFiles();
//        assert listOfFiles != null;
//        Stream.Builder<Arguments> arguments = Stream.builder();
//        for (File file : listOfFiles) {
//            if (file.isFile() && file.getName().startsWith("grep-test")) {
//                String commandToRun = file.getName();
//                List<String> params = List.of("-w", "-i",
//                        "-A 3", "-w -i",
//                        "-w -A 3", "-i -A 3",
//                        "-w -i -A 3");
//                List<String> regex = List.of("Минимальный", "минимальный",
//                        "Минимал", "минимал",
//                        "минимальный$", "^минимальный");
//                for (String param : params) {
//                    for (String reg : regex) {
//                        arguments.add(Arguments.of(param + " " + reg + " build/resources/test/" + commandToRun, 0));
//                    }
//                }
//            }
//        }
//        return arguments.build();
//    }
}