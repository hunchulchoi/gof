package ch03_decorator.io;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class LowerCaseInputStreamTest  {

  @Test
  void read() throws IOException {

    URL resource = this.getClass().getClassLoader().getResource("test.txt");

    try(InputStream in = new LowerCaseInputStream(new FileInputStream(resource.getFile()))){

      int c;
      while((c=in.read())!=-1){
        System.out.print((char)c);
      }
    }


  }
}