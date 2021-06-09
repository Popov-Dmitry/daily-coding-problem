package p1_100.p11___Twitter;

import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution("de"));
    }

   public static Set<String> solution(String query){
       Set<String> set = Set.of("dog", "deer", "deal");
       return set.stream().filter(s -> s.startsWith(query)).collect(Collectors.toSet());
   }

}
