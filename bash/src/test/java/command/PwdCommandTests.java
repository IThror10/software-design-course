package command;

import org.example.command.Command;
import org.example.command.embedded.PwdCommand;
import org.example.execution.Executor;
import org.example.execution.context.Context;
import org.junit.jupiter.api.Test;

import util.ConsoleCommandRunner;
import util.MockOutputStream;

import java.util.List;

public class PwdCommandTests {

//    @Test
//    void pwdCommandTest() throws Exception {
//
//        try (MockOutputStream mockOutputStream = new MockOutputStream()) {
//            Command command = new PwdCommand(List.of(), List.of());
//            Context context = new Context();
//
//            Executor executor = new Executor();
//            int code = executor.executeProcess(command, context);
//
//            assert(code == 0);
//            String correctOutput = ConsoleCommandRunner.call("pwd");
//
//            assert correctOutput != null;
//            mockOutputStream.ensureEquals(correctOutput);
//
//
//        }
//    }
}
