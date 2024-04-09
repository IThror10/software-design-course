import org.example.command.Command;
import org.example.execution.Executor;
import org.example.execution.context.Context;
import org.example.execution.descriptor.AbstractDescriptor;
import org.example.execution.descriptor.FileDescriptor;
import org.example.execution.exception.ExecutionException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ExecutorTests {

//    @Test
//    void systemCommandWithStdinAndStdout() throws ExecutionException, IOException {
//
//        Command command = new Command(Path.of("grep"), List.of("Ah"), List.of());
//
//        Path inputPath = Paths.get("src/test/resources/sample.txt").toAbsolutePath();
//        Path resultPath = Paths.get(Files.createTempFile("bashik_", "").toUri()).toAbsolutePath();
//
//        Context context = new Context()
//                .forkStdin(new FileDescriptor(AbstractDescriptor.Type.Input, inputPath.toFile()))
//                .forkOutput(new FileDescriptor(AbstractDescriptor.Type.Output, resultPath.toFile()));
//
//        Executor executor = new Executor();
//        int code = executor.executeProcess(command, context);
//
//        assert (code == 0);
//
//        String expected = "Ah friend, my friend,\nAh, how I love these poets!\nAh, night!\n";
//        String actual = new String(Files.readAllBytes(resultPath));
//        assert (expected.equals(actual));
//
//    }


    // Does not work
    // @Test
    // void systemCommandWithShellStdout() throws ExecutionException, IOException {
    //
    // util.MockOutputStream mockOutputStream = new util.MockOutputStream();
    // System.setOut(mockOutputStream.getPrintStream());
    //
    // Command command = new Command(Path.of("cat"),
    // List.of("src/test/resources/three-lines.txt"), List.of());
    //
    // Context context = new Context();
    //
    // Executor executor = new Executor();
    // int code = executor.executeProcess(command, context);
    //
    // assert(code == 0);
    //
    // mockOutputStream.ensureEquals(
    // "Never gonna give you up\nNever gonna let you down\nNever gonna run around
    // and desert you\n"
    // );
    //
    // }

}
