class Solution {
    public String countAndSay(int n)
    {
        String wrd = "1";

        for (int u = 1; u < n; u++)
        {
            String wwrd = "";

            for (int i = 0; i < wrd.length(); )
            {
                int c = 1;

                int j = i + 1;

                while (j < wrd.length() &&
                       wrd.charAt(i) == wrd.charAt(j))
                {
                    c++;
                    j++;
                }

                wwrd = wwrd + c;
                wwrd = wwrd + wrd.charAt(i);

                i = j;
            }

            wrd = wwrd;
        }

        return wrd;
    }
}