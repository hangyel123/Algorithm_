
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
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();

        LinkedList<Character> list = new LinkedList<Character>();
        for(char c : str.toCharArray()){
            list.add(c);
        }
        ListIterator<Character> iter = list.listIterator(list.size());

        int M = Integer.parseInt(br.readLine());
        for(int i=0;i<M;i++){
            String cmd = br.readLine();
            char op = cmd.charAt(0);

            switch(op){
                case 'L':
                    if(iter.hasPrevious()){
                        iter.previous();
                    }
                    break;
                case 'D':
                    if(iter.hasNext()){
                        iter.next();
                    }
                    break;
                case 'B':
                    if(iter.hasPrevious()){
                        iter.previous();
                        iter.remove();
                    }
                    break;
                case 'P':
                    iter.add(cmd.charAt(2));
                    break;
            }
        }
        for(char c : list){
            sb.append(c);
        }
        System.out.println(sb);
    }
}
