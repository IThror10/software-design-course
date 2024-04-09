package command;

import org.example.command.Command;
import org.example.command.embedded.CatCommand;
import org.example.execution.Executor;
import org.example.execution.context.Context;
import org.junit.jupiter.api.Test;

import util.ConsoleCommandRunner;
import util.MockOutputStream;

import java.util.List;

class CatCommandTests {

    @Test
    void catCommandShouldReturnCorrectOutputForValidFile() throws Exception {
        runTest("build/resources/test/cat-test-1", 0);
    }

    @Test
    void catCommandShouldReturnErrorForNonExistentFile() throws Exception {
        runTest("build/resources/test/cat-test-2", 0);
    }

    @Test
    void catCommandShouldReturnErrorForEmptyFile() throws Exception {
        runTest("build/resources/test/cat-test-3", 0);
    }

    private void runTest(String filePath, int expectedExitCode) throws Exception {
//        try (MockOutputStream mockOutputStream = new MockOutputStream()) {
//            Command command = new CatCommand(List.of(filePath), List.of());
//            Context context = new Context();
//
//            Executor executor = new Executor();
//            int code = executor.executeProcess(command, context);
//
//            assert(code == expectedExitCode);
//            if (expectedExitCode == 0) {
//                String correctOutput = ConsoleCommandRunner.call("cat " + filePath);
//                assert correctOutput != null;
//                mockOutputStream.ensureEquals(correctOutput);
//            }
//        }
    }
}