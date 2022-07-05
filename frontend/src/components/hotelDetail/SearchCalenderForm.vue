<!-- 다시 살리게 될 일 생길까봐 일단 삭제는 하지 않고 살려둠-->
<template>
    <v-container>
        <table style="width: 80%">
            <tr>
                <td>
                <h1 align="left">객실 소개</h1>
                </td>
                <!-- 검색창 -->
                <td align="right">

                    <v-row>
                    <v-spacer></v-spacer>
                    <!-- 수직상 top에 딱 맞춰져 있어서 검색바랑 버튼이 수평이 안맞아보임. 아마 cols 값 안고쳐서 그런 것도 있는듯 -->
                        <v-col cols="12" xs="6" sm="3" md="3">
                            <v-menu class="menu1" :close-on-content-click="false" transition="scale-transition"
                                offset-y>
                                <template v-slot:activator="{ on, attrs }">
                                    <v-text-field class="DateSearch"  label="날짜 선택" v-model="planDate"
                                        prepend-icon="mdi-calendar" v-bind="attrs" v-on="on"
                                        rounded solo readonly></v-text-field>
                                </template>
                                <v-date-picker v-model="dates" 
                                                :min="new Date(Date.now() - new Date().getTimezoneOffset() * 60000).toISOString().substr(0,10)" range
                                                >
                                </v-date-picker>
                            </v-menu>
                        </v-col>
                        <v-col cols="12" xs="12" sm="12" md="2">
                            <v-select v-model="personnel" :items="items" item-value="value" prepend-icon="mdi-bed" label="인원 선택" class="PickPeople" rounded solo>
                            </v-select>
                        </v-col>
                        <v-col cols="12" xs="1" sm="1" md="1">
                            <v-btn @click="searchRoom()" type="submit" value="Subscribe">
                                검색하기
                            </v-btn>
                        </v-col>

                        &ensp; &ensp; &ensp;
                    </v-row>

                </td>
            </tr>
        </table>
    </v-container>
</template>

<script>
export default {
    name: 'MSearchCalenderForm',
    data: () => ({
        dates: [],
        items: ['1', '2', '3', '4'],
        value: null,
        personnel: '',
    }),
    computed: {
        planDate () {
            if(this.dates.length == 2) {
                if(this.dates[0] >= this.dates[1]){
                    alert ('다시 선택하세요')
                    this.initDates()
                }
            }
            return this.dates.join(' ~ ')
        },
    },
    methods: {
        initDates() {
            return this.dates = []
        },
    /*  searchRoom() {
            console.log(this.dates)
            const { dates, personnel , city} = this
            axios.post('http://localhost:7777/search/commonSearch', {dates, personnel})
                    .then((res) => {
                        console.log("검색 성공")
                        console.log(res.data)
                        
                        
                        this.$router.push({name: 'CommonSearchPage',
                                    params: { searchList: res.data } })
                    .catch(() => {});
                })
                .catch(() => {
                alert("검색 실패");
            });
            
        }, */
    }
}
</script>

<style scoped>

</style>