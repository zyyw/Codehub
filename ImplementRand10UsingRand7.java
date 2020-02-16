/*
Given a function rand7 which generates a uniform random integer
in the range 1 to 7, write a function rand10 which generates
a uniform random integer in the range 1 to 10.

Do NOT use system's Math.random().

* The rand7() API is already defined in the parent class SolBase.
* public int rand7();
* @return a random integer in the range 1 to 7

思路：
https://blog.csdn.net/fuxuemingzhu/article/details/81809478
https://www.cnblogs.com/grandyang/p/9727206.html

*/

class ImplementRand10UsingRand7 extends SolBase {
    public int rand10() {
        while (true) {
            int idx = (rand7() - 1) * 7 + rand7();
            if (idx <= 40) {
                return idx % 10 + 1;
            }
        }
    }
}

/*
class ImplementRand7UsingRand5 extends SolBase {
    public int rand7() {
        while (true) {
            int idx = (rand5() - 1) * 5 + rand5();
            if (idx <= 31) {
                return idx % 7 + 1;
            }
        }
    }
}
*/
