import java.util.*;

public class NewClass3 {

  public static void main(String[] args) {
    HashMap<String, Double> marksBySubjects = new HashMap<>();
    marksBySubjects.put("Math", 9.0);
    marksBySubjects.put("Physics", 7.5);
    marksBySubjects.put("Chemistry", 9.0);
    marksBySubjects.put("Economics", 8.5);
    marksBySubjects.put("Geography", 9.5);


    // In ra màn hình điểm của các môn học
    System.out.println(marksBySubjects.get("Math"));
    System.out.println(marksBySubjects.get("Physics"));
    System.out.println(marksBySubjects.get("Chemistry"));
    System.out.println(marksBySubjects.get("Economics"));
    System.out.println(marksBySubjects.get("Geography"));

    // Sử dụng phép lặp để in điểm ra màn hình
    marksBySubjects
        .entrySet()
        .forEach(entry -> {
          System.out.println(entry.getKey() + ":\t" + entry.getValue());
        });

    // In ra màn hình số lượng ánh xạ có trong map
    System.out.println("\n");
    System.out.println("Size: " + marksBySubjects.size());

    // In ra màn hình danh sách các môn học
    // Java 8
    marksBySubjects
        .keySet()
        .forEach(System.out::println);

    // Java 7
    for (String subject: marksBySubjects.keySet()) {
        System.out.println("\n");
      System.out.println(subject);
    }
  }
}