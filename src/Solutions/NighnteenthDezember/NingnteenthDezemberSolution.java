package Solutions.NighnteenthDezember;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NingnteenthDezemberSolution {

        public void Solution() {
        var patH = Pattern.compile("--- scanner (\\d+) ---");
        var patL = Pattern.compile("(-?\\d+),(-?\\d+),(-?\\d+)");
            List<String> inp = null;
            try {
                inp = Files.lines(Paths.get("input.txt")).toList();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Deque<Set<Beacon>> scanners = new LinkedList<>();
        for (String s : inp) {
            if (patH.matcher(s).find()) {
                scanners.add(new HashSet<>());
                continue;
            }
            var m = patL.matcher(s);
            if (m.find())
                scanners.getLast().add(new Beacon(Integer.parseInt(m.group(1)), Integer.parseInt(m.group(2)), Integer.parseInt(m.group(3))));
        }
        System.out.println(scanners.size());
        var scannerSet = new HashSet<Beacon>();
        scannerSet.add(new Beacon(0,0,0));
        var nullSet = scanners.pop();
        outer:
        while (!scanners.isEmpty()) {
            var ns = scanners.pop();
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 4; k++) {
                    for (Beacon n : ns) {
                        for (Beacon b : nullSet) {
                            var delta = new Beacon(b.x - n.x,b.y - n.y,b.z - n.z);
                            var shift = ns.stream().map(x -> x.applyDelta(delta)).collect(Collectors.toSet());
                            var count = 0;
                            for (Beacon beacon1 : shift) {
                                if (nullSet.contains(beacon1)) count++;
                                if (count >= 12) {
                                    nullSet.addAll(shift);
                                    scannerSet.add(delta);
                                    continue outer;
                                }
                            }
                        }
                    }
                    ns = ns.stream().map(x -> x.rotate("x")).collect(Collectors.toSet());
                }
                if (j < 5) {
                    if (j < 3) ns = ns.stream().map(x -> x.rotate("y")).collect(Collectors.toSet());
                    if (j > 2) ns = ns.stream().map(x -> x.rotate("z")).collect(Collectors.toSet());
                    if (j == 4) ns = ns.stream().map(x -> x.rotate("z")).collect(Collectors.toSet());
                }
            }
            scanners.add(ns);
        }
        var max = 0;
        System.out.println(nullSet.size());
        for (Beacon b1 : scannerSet) {
            for (Beacon b2 : scannerSet) {
                max = Math.max(max, b1.distance(b2));
            }
        }
        System.out.println(max);
    }

    record Beacon(int x, int y, int z) {
        public Beacon applyDelta(Beacon b) {
            return new Beacon(this.x + b.x, this.y + b.y, this.z + b.z);
        }
        public Beacon rotate(String axis) {
            return switch (axis) {
                case "x" -> new Beacon(x, z, -y);
                case "y" -> new Beacon(-z, y, x);
                case "z" -> new Beacon(y, -x, z);
                default -> null;
            };
        }
        public int distance(Beacon b){
            return Math.abs(this.x-b.x)+Math.abs(this.y-b.y)+Math.abs(this.z-b.z);
        }
    }
}