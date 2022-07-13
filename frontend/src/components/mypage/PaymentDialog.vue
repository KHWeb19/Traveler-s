<template>
    <div>
        <v-dialog v-model="dialog" width="600px">
            <template v-slot:activator="{ on }">
                <button v-on="on"  dark>
                        <v-icon> mdi-chevron-right </v-icon>
                </button>
            </template>

                <v-card align="center">
                    <v-card-title>결제 및 예약취소에 관한 안내사항</v-card-title>
                    <v-card-text>
                        Traveler's 사이트 중개를 이용한 숙박 예약에 관하여 '소비자분쟁해결기준'을 준수한 환불 및 위약금 규정을 사전 공지합니다.<br><br>


                        10일 전 취소: 100% 환불<br>
                        7~9일 전 취소: 위약금 10%<br>
                        5~6일 전 취소: 위약금 30%<br>
                        2일 전 취소: 위약금 50%<br>
                        1일~당일 취소: 위약금 80%<br><br>

                        <br><br>1372 소비자상담센터<br>
                    </v-card-text>
                    <v-card-actions>
                        <v-spacer></v-spacer>
                        <v-btn @click="cancel">
                            확인
                        </v-btn>
                        <v-spacer></v-spacer>
                    </v-card-actions>

                </v-card>

      </v-dialog>
    </div>
</template>

<script>
export default {
    name: 'PaymentDialog', 
    data: () => ({
        dialog: false
    }),
    methods: {
        cancel(){
            this.dialog = false
        },
    }
}
</script>
