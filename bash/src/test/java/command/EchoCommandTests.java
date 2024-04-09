package command;

import org.example.command.Command;
import org.example.command.embedded.EchoCommand;
import org.example.execution.Executor;
import org.example.execution.context.Context;
import org.junit.jupiter.api.Test;

import java.util.List;

import util.ConsoleCommandRunner;
import util.MockOutputStream;

public class EchoCommandTests {

//    @Test
//    void echoTest() throws Exception {
//
//        try (MockOutputStream mockOutputStream = new MockOutputStream()) {
//            String text = "some text 123 and //$123&^%@#$*(&*#±";
//            Command command = new EchoCommand(List.of(text), List.of());
//            Context context = new Context();
//
//            Executor executor = new Executor();
//            int code = executor.executeProcess(command, context);
//
//            assert(code == 0);
//            String correctOutput = ConsoleCommandRunner.call("echo " + text);
//            assert correctOutput != null;
//            mockOutputStream.ensureEquals(correctOutput);
//        }
//    }
}
