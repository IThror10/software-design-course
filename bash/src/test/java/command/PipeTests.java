package command;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.ast.concrete.UnresolvedCommandExpression;
import org.example.ast.sequential.PipeExpression;
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

public class PipeTests {

//    @Test
//    void simplePipeCommandWithEmbeddedCommandAndSystemCommand() throws ExecutionException, IOException {
//
//        Path resultPath = Paths.get(Files.createTempFile("bashik_", "").toUri()).toAbsolutePath();
//        Executor executor = new Executor();
//        Context context = new Context()
//                .forkOutput(new FileDescriptor(AbstractDescriptor.Type.Output, resultPath.toFile()));
//
//        PipeExpression expression = new PipeExpression(
//                new UnresolvedCommandExpression("cat src/test/resources/three-lines.txt"),
//                new UnresolvedCommandExpression("/usr/bin/grep up")
//        );
//
//        expression.run(executor, context);
//
//        String expected = "Never gonna give you up\n";
//        String actual = new String(Files.readAllBytes(resultPath));
//        assertEquals(expected, actual);
//
//    }
//
//    @Test
//    void simplePipeCommandWithSystemCommands() throws ExecutionException, IOException {
//
//        Path resultPath = Paths.get(Files.createTempFile("bashik_", "").toUri()).toAbsolutePath();
//        Executor executor = new Executor();
//        Context context = new Context()
//                .forkOutput(new FileDescriptor(AbstractDescriptor.Type.Output, resultPath.toFile()));
//
//        PipeExpression expression = new PipeExpression(
//                new UnresolvedCommandExpression("cat src/test/resources/three-lines.txt"),
//                new PipeExpression(
//                    new UnresolvedCommandExpression("/usr/bin/grep up"),
//                    new PipeExpression(
//                            new UnresolvedCommandExpression("/usr/bin/wc -w"),
//                            new UnresolvedCommandExpression("xargs") // to support macos wc behavior
//                    )
//                )
//        );
//
//        expression.run(executor, context);
//
//        String expected = "5\n";
//        String actual = new String(Files.readAllBytes(resultPath));
//        assertEquals(expected, actual);
//
//    }

}
