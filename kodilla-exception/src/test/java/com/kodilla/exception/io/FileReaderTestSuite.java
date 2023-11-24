package com.kodilla.exception.io;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class FileReaderTestSuite {
    @Test
    void testReadFile() {
        // given
        FileReader fileReader = new FileReader();
        // when & then
        assertDoesNotThrow(() -> fileReader.readFile());
    }
}
