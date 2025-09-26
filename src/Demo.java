import java.io.FileNotFoundException;
import java.io.PrintWriter;

class Demo {

  public static void main(String[] args) throws FileNotFoundException {

    final Printer printer = new Printer(new PrintWriter("/tmp/out"));

    // add shutdown hook
    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
      printer.println("Goodbye!");
      printer.close();
    }));

    for (int i = 0; i < 5; i++) {
      try {
        Thread.sleep(1000L);
      } catch (InterruptedException e) {
        break;
      }
      printer.println("Hello from Java");
    }
  }


  private static class Printer {

    final PrintWriter writer;

    private Printer(PrintWriter writer) {
      this.writer = writer;
    }

    void close() {
      writer.close();
    }

    void println(String message) {
      writer.println(message);
      writer.flush();
      System.out.println(message);
    }
  }
}
