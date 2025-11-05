class Solution {
    public String predictPartyVictory(String senate) {
         StringBuilder sb = new StringBuilder(senate);
        int rCount = 0, dCount = 0;

        for (char c : sb.toString().toCharArray()) {
            if (c == 'R') rCount++;
            else dCount++;
        }

        int banR = 0, banD = 0;

        while (rCount > 0 && dCount > 0) {
            StringBuilder nextRound = new StringBuilder();

            for (int i = 0; i < sb.length(); i++) {
                char c = sb.charAt(i);
                if (c == '.') continue;

                if (c == 'R') {
                    if (banR > 0) {
                        banR--;
                        rCount--;
                        continue; // R banned this round
                    }
                    // R acts → ban a D in next round
                    banD++;
                    nextRound.append('R');
                } else { // D
                    if (banD > 0) {
                        banD--;
                        dCount--;
                        continue; // D banned this round
                    }
                    // D acts → ban an R in next round
                    banR++;
                    nextRound.append('D');
                }
            }

            sb = nextRound; // prepare next round
        }

        return rCount > 0 ? "Radiant" : "Dire";
    }
}
    