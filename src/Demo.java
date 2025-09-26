class Demo {
  public static void main(String[] args) {
    // add shutdown hook
    Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("Goodbye!")));

    for (int i = 0; i < 5; i++) {
      try {
        Thread.sleep(1000L);
      } catch (InterruptedException e) {
        break;
      }
      System.out.println("Hello from Java");
    }
  }
}
