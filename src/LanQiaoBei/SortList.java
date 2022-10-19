package LanQiaoBei;

import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改
public class SortList {
    //30行59列
   public static int count(char ch[][],int m,int n){
        int ans=0;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                int add=1;
                while(j+add<n){
                  if(ch[i][j]<ch[i][j+add]) ans++;  //横
                  add++;
                }
                add=1;
                while(i+add<m){
                  if(ch[i][j]<ch[i+add][j]) ans++; //列递增
                  add++;
                }
                add=1;
                while (i+add<m&&j+add<n){
                    if (ch[i][j]<ch[i+add][j+add]) ans++; //右下
                    add++;
                }
                add =1;
                while(i-add>=0&&j+add<n){
                    if (ch[i][j]<ch[i-add][j+add]) ans++; //右上
                    add++;
                }
                add=1;
                while(i+add<m&&j-add>=0){
                    if (ch[i][j]<ch[i+add][j-add]) ans++; //左下
                    add++;
                }
            }
        }
        

       return ans;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m=30,n=50;
        char ch[][] = new char[m][n];
        for(int i=0;i<m;i++){
            char st[] = scan.nextLine().toCharArray();
            ch[i] = st;
        }
        System.out.println(count(ch,m,n));
        //在此输入您的代码...
        scan.close();
//        System.out.println("52800");
    }
    /**
     * VLPWJVVNNZSWFGHSFRBCOIJTPYNEURPIGKQGPSXUGNELGRVZAG
     * SDLLOVGRTWEYZKKXNKIRWGZWXWRHKXFASATDWZAPZRNHTNNGQF
     * ZGUGXVQDQAEAHOQEADMWWXFBXECKAVIGPTKTTQFWSWPKRPSMGA
     * BDGMGYHAOPPRRHKYZCMFZEDELCALTBSWNTAODXYVHQNDASUFRL
     * YVYWQZUTEPFSFXLTZBMBQETXGXFUEBHGMJKBPNIHMYOELYZIKH
     * ZYZHSLTCGNANNXTUJGBYKUOJMGOGRDPKEUGVHNZJZHDUNRERBU
     * XFPTZKTPVQPJEMBHNTUBSMIYEGXNWQSBZMHMDRZZMJPZQTCWLR
     * ZNXOKBITTPSHEXWHZXFLWEMPZTBVNKNYSHCIQRIKQHFRAYWOPG
     * MHJKFYYBQSDPOVJICWWGGCOZSBGLSOXOFDAADZYEOBKDDTMQPA
     * VIDPIGELBYMEVQLASLQRUKMXSEWGHRSFVXOMHSJWWXHIBCGVIF
     * GWRFRFLHAMYWYZOIQODBIHHRIIMWJWJGYPFAHZZWJKRGOISUJC
     * EKQKKPNEYCBWOQHTYFHHQZRLFNDOVXTWASSQWXKBIVTKTUIASK
     * PEKNJFIVBKOZUEPPHIWLUBFUDWPIDRJKAZVJKPBRHCRMGNMFWW
     * CGZAXHXPDELTACGUWBXWNNZNDQYYCIQRJCULIEBQBLLMJEUSZP
     * RWHHQMBIJWTQPUFNAESPZHAQARNIDUCRYQAZMNVRVZUJOZUDGS
     * PFGAYBDEECHUXFUZIKAXYDFWJNSAOPJYWUIEJSCORRBVQHCHMR
     * JNVIPVEMQSHCCAXMWEFSYIGFPIXNIDXOTXTNBCHSHUZGKXFECL
     * YZBAIIOTWLREPZISBGJLQDALKZUKEQMKLDIPXJEPENEIPWFDLP
     * HBQKWJFLSEXVILKYPNSWUZLDCRTAYUUPEITQJEITZRQMMAQNLN
     * DQDJGOWMBFKAIGWEAJOISPFPLULIWVVALLIIHBGEZLGRHRCKGF
     * LXYPCVPNUKSWCCGXEYTEBAWRLWDWNHHNNNWQNIIBUCGUJYMRYW
     * CZDKISKUSBPFHVGSAVJBDMNPSDKFRXVVPLVAQUGVUJEXSZFGFQ
     * IYIJGISUANRAXTGQLAVFMQTICKQAHLEBGHAVOVVPEXIMLFWIYI
     * ZIIFSOPCMAWCBPKWZBUQPQLGSNIBFADUUJJHPAIUVVNWNWKDZB
     * HGTEEIISFGIUEUOWXVTPJDVACYQYFQUCXOXOSSMXLZDQESHXKP
     * FEBZHJAGIFGXSMRDKGONGELOALLSYDVILRWAPXXBPOOSWZNEAS
     * VJGMAOFLGYIFLJTEKDNIWHJAABCASFMAKIENSYIZZSLRSUIPCJ
     * BMQGMPDRCPGWKTPLOTAINXZAAJWCPUJHPOUYWNWHZAKCDMZDSR
     * RRARTVHZYYCEDXJQNQAINQVDJCZCZLCQWQQIKUYMYMOVMNCBVY
     * ABTCRRUXVGYLZILFLOFYVWFFBZNFWDZOADRDCLIRFKBFBHMAXX
     */
}