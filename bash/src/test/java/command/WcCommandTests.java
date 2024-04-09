package command;

import org.example.command.Command;
import org.example.command.embedded.WcCommand;
import org.example.execution.Executor;
import org.example.execution.context.Context;
import org.junit.jupiter.api.Test;

import util.ConsoleCommandRunner;
import util.MockOutputStream;

import java.util.List;

class WcCommandTests {

    @Test
    void wcCommandTest1() throws Exception {
        runTest("build/resources/test/wc-test-1");
    }

    @Test
    void wcCommandTest2() throws Exception {
        runTest("build/resources/test/wc-test-2");
    }

    @Test
    void wcCommandTest3() throws Exception {
        runTest("build/resources/test/wc-test-3");
    }

    private void runTest(String filePath) throws Exception {
//        try (MockOutputStream mockOutputStream = new MockOutputStream()) {
//            Command command = new WcCommand(List.of(filePath), List.of());
//            Context context = new Context();
//
//            Executor executor = new Executor();
//            int code = executor.executeProcess(command, context);
//
//            assert(code == 0);
//            String correctOutput = ConsoleCommandRunner.call("wc " + filePath);
//            assert correctOutput != null;
//            String correctOutputFormed = String.join(" ", correctOutput.strip().split("\\s+"));
//            mockOutputStream.ensureEquals(correctOutputFormed);
//        }
    }
}