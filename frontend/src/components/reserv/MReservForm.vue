<template>
    <v-container>
        <table style="width: 80%">
            <tr>
                <td>
                    <table>
                        <tr>
                            <td>
                                <h3>예약자 정보</h3>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                대표 투숙자
                            </td>
                            <td>
                                김땡땡
                            </td>
                       </tr>
                        <tr>
                            <td>
                                숙소 이름
                            </td>
                            <td>
                                hotel#1
                            </td>
                       </tr>
                        <tr>
                            <td>
                                객실명
                            </td>
                            <td>
                                객실 no.2
                            </td>
                        </tr>
                        <tr>
                            <td>
                                숙박일
                            </td>
                            <td>
                                2022.06.30 ~ 2022.07.01
                            </td>
                        </tr>
                        <tr>
                            <td>
                                숙박 인원
                            </td>
                            <td>
                                4명
                            </td>
                        </tr>
                        <tr>
                            <td>
                                가격
                            </td>
                            <td>
                                100,000 원
                            </td>
                        </tr>
                    </table>
                    <br>
                    
                </td>
            </tr>
    <hr>
            <tr>
                <td>
                    <br>
                    <table>
                        <tr>
                            <td>
                                <h3>약관 안내</h3>
                            </td>                         
                        </tr>
                        <tr>
                            <td>
                                <input type="checkbox">
                            </td>
                            <td>
                                여행자 약관 동의 (필수)
                            </td>
                            <td>
                                <agree-dialog-one/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input type="checkbox">
                            </td>
                            <td>
                                개인정보 제공 동의 (필수)
                            </td>
                            <td>
                                <agree-dialog-two/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input type="checkbox">
                            </td>
                            <td>
                                개인정보 수집 및 이용 동의 (필수)
                            </td>
                            <td>
                                <agree-dialog-three/>
                            </td>
                        </tr>
                    </table>
                    <br>
                </td>
            </tr>
<hr>
            <tr>
                <td>
                    <br>
                    <table>
                        <tr>
                            <td>
                                <h3>결제 정보</h3>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form>
                                    <input type="radio" id="bankBook" name="bankBook" value="bankBook">
                                    <label for="bankBook">무통장 입금</label><br>

                                    <input type="radio" id="card" name="card" value="card">
                                    <label for="card">신용/체크카드</label><br>

                                    <input type="radio" id="toss" name="toss" value="toss">
                                    <label for="toss">토스 결제</label><br>

                                </form>
                            </td>
                        </tr>
                    </table>
                    
                </td>
            </tr>
            <tr>
                <td>
                    <br>
                        <v-btn>
                            결제하기
                        </v-btn>
                </td>
            </tr>
        </table>
    </v-container>
</template>

<script>
import AgreeDialogOne from '@/components/reserv/AgreeDialogOne.vue'
import AgreeDialogTwo from '@/components/reserv/AgreeDialogTwo.vue'
import AgreeDialogThree from '@/components/reserv/AgreeDialogThree.vue'


export default {
    name: 'MReservForm',
    components: {
        AgreeDialogOne,
        AgreeDialogThree,
        AgreeDialogTwo
        },
    data() {
        return {
            payList: [
                { index: '0', text: '무통장 입금', icon: 'mdi-card', value: 'bankBook' },
                { index: '1', text: '신용/체크카드', icon: 'mdi-card', value: 'card' },
                { index: '2', text: '토스 결제', icon: 'mdi-card', value: 'toss' },
],
        }
    }
}
</script>

<style scoped>
table, th, td{
    border-collapse:collapse;
    border: 1px solid black;
}
</style>