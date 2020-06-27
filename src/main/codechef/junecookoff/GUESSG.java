package main.codechef.junecookoff;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GUESSG {

    public static void main(String[] args) throws IOException {

        another();

       /* Scanner in = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new
                InputStreamReader(System.in));


          int  n = Integer.parseInt(br.readLine());
            int x=0;
            int l = 1;
            int h = n;
            int count = 0;

            while (l < h){
                x++;
                int mid = l+((h-l)/2);
                if(mid % 2 != 0){
                    mid = mid+1;
                }
                if(l + 1 == h){
                    //inline values
                    mid = l;
                }


                count++;
                System.out.println(mid);
                   String rly = br.readLine();
                    if("E".equalsIgnoreCase(rly)){
                        //System.out.println(x);
                        break;
                    } else if("G".equalsIgnoreCase(rly)){
                        if(mid % 2 == 0){
                            l = mid;
                            count = 0;
                        } else if(count == 2){
                            l = mid;
                            count = 0;
                        }
                    } else {
                        if(mid % 2 == 0) {
                            h = mid;
                            count = 0;
                        } else if(count == 2){
                            h = mid;
                            count = 0;
                        }
                    }



        }*/


    }


    public static void another() throws IOException {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);

        int n = in.nextInt();
        int l = 1;
        int h = n;

        while (l <= h) {

            int mid = l + ((h - l) / 2);
            int falseMid = mid;

            if (mid % 2 != 0 && h - l != 1 && h !=l) {
                falseMid = mid + 1;
            } else if (mid % 2 == 0 && h - l == 1) {
                falseMid = mid + 1;
            }

            //out.println("mid -> "+mid+" l->"+l+" h->"+h);
            out.println(falseMid);
            out.flush();

            String rly = in.next();

            if ("E".equalsIgnoreCase(rly)) {
                break;
            } else if ("G".equalsIgnoreCase(rly)) {
                l = falseMid+1;
            } else if ("L".equalsIgnoreCase(rly)) {
                h = falseMid-1;
            }


        }


    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (this.numChars == -1) {
                throw new InputMismatchException();
            } else {
                if (this.curChar >= this.numChars) {
                    this.curChar = 0;

                    try {
                        this.numChars = this.stream.read(this.buf);
                    } catch (IOException var2) {
                        throw new InputMismatchException();
                    }

                    if (this.numChars <= 0) {
                        return -1;
                    }
                }

                return this.buf[this.curChar++];
            }
        }

        public int nextInt() {
            int c;
            for (c = this.read(); isSpaceChar(c); c = this.read()) {
                ;
            }

            byte sgn = 1;
            if (c == 45) {
                sgn = -1;
                c = this.read();
            }

            int res = 0;

            while (c >= 48 && c <= 57) {
                res *= 10;
                res += c - 48;
                c = this.read();
                if (isSpaceChar(c)) {
                    return res * sgn;
                }
            }

            throw new InputMismatchException();
        }

        public String next() {
            int c;
            while (isSpaceChar(c = this.read())) {
                ;
            }

            StringBuilder result = new StringBuilder();
            result.appendCodePoint(c);

            while (!isSpaceChar(c = this.read())) {
                result.appendCodePoint(c);
            }

            return result.toString();
        }

        public static boolean isSpaceChar(int c) {
            return c == 32 || c == 10 || c == 13 || c == 9 || c == -1;
        }

    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void println(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

        public void flush() {
            writer.flush();
        }

    }
}