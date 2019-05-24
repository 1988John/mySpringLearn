package com.foo.test.base.buffer;

import java.nio.CharBuffer;

public class BufferDemo {
   public static void main (String [] args) {
      //allocate a character type buffer.
      CharBuffer buffer = CharBuffer.allocate(10);
      String text = "bufferDemo";
      System.out.println("Input text: " + text);
      for (int i = 0; i < text.length(); i++) {
         char c = text.charAt(i);
         //put character in buffer.
		 buffer.put(c);
      }
      int buffPos = buffer.position();
      System.out.println("Position after data is written into buffer: " + buffPos);
      buffer.flip();
      System.out.println("Reading buffer contents:");
      while (buffer.hasRemaining()) {
         System.out.println(buffer.get());                   
      }
      //set the position of buffer to 5.
      buffer.position(5);
      //sets this buffer's mark at its position
      buffer.mark();
      //try to change the position
      buffer.position(6);
      //calling reset method to restore to the position we marked.
      //reset() raise InvalidMarkException if either the new position is less
      //than the position marked or merk has not been setted.
      buffer.reset();
      System.out.println("Restored buffer position : " + buffer.position());
   }
}