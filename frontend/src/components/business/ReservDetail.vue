<template>
   <div align="center">
      <v-layout justify-center>
            <v-dialog  v-model="findPw" resisten max-width="800px">
               <template v-slot:activator="{ on }">
               <v-btn style="color: black" v-on="on">
                  상세보기
               </v-btn>
               </template>
               <v-card align="center">
                  <v-card-title id="title">
                     김땡땡 고객님 예약정보
                  </v-card-title>

                  <form>

   <!-- disabled는 컨트롤러로 값이 넘어오지 않는다.
      readonly를 사용하면 입력만 막고 값은 넘길 수 있다. -->

                     <table>
                        <tr>
                           <td>
                              예약번호
                           </td>
                           <td>
                              &ensp;
                              <input type="text" id="cantTouch" value="3052349" readonly/>
                           </td>
                        </tr>

                        <tr>
                           <td>
                              예약자명
                           </td>
                           <td>
                              &ensp;
                              <input type="text" id="cantTouch" value="김땡땡" readonly/>
                           </td>
                        </tr>

                        <tr>
                           <td>
                              휴대폰 번호
                           </td>
                           <td>
                              &ensp;
                              <input type="text" id="cantTouch" value="010-0000-0000" readonly/>
                           </td>
                        </tr>

                        <tr>
                           <td>
                              이메일
                           </td>
                           <td>
                              &ensp;
                              <input type="email" id="cantTouch" value="wefadf@naver.com" readonly/>
                           </td> <!--  텍스트 입력 필드처럼 보이지만 유효성 검증 매개변수가 존재 -->
                        </tr>

                        <tr>
                           <td>
                              체크인
                           </td>
                           <td>
                              &ensp;
                              <input type="date" id="cantTouch" value="2022-06-20" readonly/>
                           </td>
                        </tr>

                        <tr>
                           <td>
                              체크아웃
                           </td>
                           <td>
                              &ensp;
                              <input type="date" id="cantTouch" value="2022-06-23" readonly/>
                           </td>
                        </tr>

                        <tr>
                           <td>
                              요금
                           </td>
                           <td>
                              &ensp;
                              <input type="text" id="cantTouch" value="100,000" readonly/>
                           </td>
                        </tr>

                        <tr>
                           <td>
                              고객 요청사항
                           </td>
                           <td>
                              &ensp;
                              <input type="text" id="cantTouch" style="height: 200px;" value="내용이 입력되어 있어요." readonly/>
                           </td>
                        </tr>

                        <tr>
                           <td>
                              객실
                           </td>
                        </tr>
                        <tr>
                           <td colspan="2">
                           <table align="center" style="width: 700px;">
                              <tr>
                                 <th align="center" width="130">날짜</th>
                                 <th align="center" width="170">객실명</th>
                                 <th align="center" width="100">요금</th>
                                 <th align="center" width="60">성인</th>
                                 <th align="center" width="60">아동</th>
                                 <th align="center" width="40">&ensp;&ensp;</th>                                 
                              </tr>

                              <tr>
                                 <td  align="center">
                                    2022-06-20 ~ &ensp;
                                    <br> &ensp; 2022-06-23
                                 </td>
                                 <td  align="center">
                                    패밀리 독채
                                 </td>                                 
                                 <td  align="center">
                                    100,000
                                 </td>
                                 <td  align="center">
                                    <input type="number" id="cantTouch" style="width: 40px;" readonly/>
                                 </td>
                                 <td  align="center">
                                    <input type="number" id="cantTouch" style="width: 40px;" readonly/>
                                 </td>
                                 <td  align="center">
                                    <v-btn id="delButton">
                                       X
                                    </v-btn>
                                 </td>
                              </tr>
                           </table>
                           </td>
                        </tr>
                     </table>
                  </form>
               <br>
                  <v-card-actions>
                     <v-spacer></v-spacer>
                     <v-btn>
                           수정
                     </v-btn>
                     <v-btn>
                           닫기
                     </v-btn>
                     <v-spacer></v-spacer>
                  </v-card-actions>
               </v-card>
            </v-dialog>
      </v-layout>
   </div>    
</template>

<script>
export default {

}
</script>

<style scoped>
#cantTouch {
   border: 1px solid gray;
   padding: 4px;
   border-radius: 4%;
   width: 500px;
   outline: none;
}
#delButton {
   padding: 25px;
   border-radius: 50px;
   background-color: brown;
   color: white;
   font-size: 20px;
}
</style>