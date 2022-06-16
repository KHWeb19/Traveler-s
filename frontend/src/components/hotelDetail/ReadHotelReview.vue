<template>
    <v-container>
        <h3>고객 리뷰</h3>
            <br>
            <v-col>
            <v-row justify="center">
                <table style="width: 95%">
                    <tr>
                        <td>
                            <p>★★★★★ &ensp;|&ensp; {{hotel.who}}고객명</p>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <p>2022.05.11 &ensp;|&ensp; {{hotel.room_name}}객실종류</p>
                        </td>
                    </tr>
                    <tr>
                        <td >
                            <p>{{hotel.content}}</p>
                        </td>
                    </tr>
                </table>
            </v-row>
            </v-col>
    </v-container>
</template>

<script>
export default {
    name: "HotelReview",

}
</script>


<style scoped>

</style>