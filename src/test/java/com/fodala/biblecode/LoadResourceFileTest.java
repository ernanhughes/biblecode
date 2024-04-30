package com.fodala.biblecode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = BibleCodeApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LoadResourceFileTest {

        private static final String GENESIS_FILE_PATH = "classpath:data/01_genesis.json";

        @Autowired
        private ResourceLoader resourceLoader = null;

        @Test
        void loadGenesisTest()  throws IOException {
            File dataFile = resourceLoader.getResource(GENESIS_FILE_PATH).getFile();
            assertTrue(dataFile.exists(), "Cannot file expected resource file: " + GENESIS_FILE_PATH);
        }
}
