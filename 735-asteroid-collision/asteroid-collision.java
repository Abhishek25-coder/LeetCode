class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> st = new ArrayDeque<>();

        for(int ast : asteroids) {

            if(ast > 0) {
                st.push(ast);
            }
            else {
                // ast < 0

                boolean destroyed = false;

                // Collision tabhi hoga jab stack top positive ho
                while(!st.isEmpty() && st.peek() > 0) {

                    if(st.peek() < -ast) {
                        // Stack wala asteroid destroy ho jayega
                        st.pop();
                        continue;
                    }
                    else if(st.peek() > -ast) {
                        // Current asteroid destroy ho jayega
                        destroyed = true;
                        break;
                    }
                    else {
                        // Dono asteroid destroy ho jayenge
                        st.pop();
                        destroyed = true;
                        break;
                    }
                }

                // Agar current asteroid destroy nahi hua
                if(!destroyed) {
                    st.push(ast);
                }
            }
        }

        // Stack ko original order me convert karna
        int[] ans = new int[st.size()];

        for(int i = st.size() - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }

        return ans;
    }
}