
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t= 0;t<T;t++){
            StringBuilder sb = new StringBuilder();
            String cmd = br.readLine();
            char[] cmdArray = cmd.toCharArray();
            LinkedList<Character> list = new LinkedList<>();
            ListIterator<Character> iter = list.listIterator(0);
            for(char c: cmdArray){
                switch (c){
                    case '<':
                        if(iter.hasPrevious()){
                            iter.previous();
                        }
                        break;
                    case '>':
                        if(iter.hasNext()){
                            iter.next();
                        }
                        break;
                    case '-':
                        if(iter.hasPrevious()){
                            iter.previous();
                            iter.remove();
                        }
                        break;
                    default:
                        iter.add(c);
                        break;
                }
            }
            for(char c : list){
                sb.append(c);
            }
            System.out.println(sb);
        }

    }
}
