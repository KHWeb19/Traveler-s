<template>
    <v-container fluid>
        <v-divider></v-divider>
        <section>
            <v-card-title class="justify-center" style="font-size:3em">테마 검색</v-card-title>
            <v-row align="center" justify="center">
                <v-btn @click="('')" rounded class="button1 b-color rot-1">#오션뷰</v-btn>
                <v-btn @click="('')" rounded class="button1 b-color rot-1">#테라스</v-btn>
                <v-btn @click="('')" rounded class="button1 b-color rot-1">#수영장</v-btn>
                <v-btn @click="('')" rounded class="button1 b-color rot-1">#전기차충전</v-btn>
                <v-btn @click="('')" rounded class="button1 b-color rot-1">#공항근처</v-btn>
                <v-btn @click="('')" rounded class="button1 b-color rot-1">#골프장</v-btn>
                <v-btn @click="('')" rounded class="button1 b-color rot-1">#무료주차</v-btn>
                <v-btn @click="('')" rounded class="button1 b-color rot-1">#바베큐그릴</v-btn>
                <v-btn @click="('')" rounded class="button1 b-color rot-1">#반려동물</v-btn>
                <v-btn @click="('')" rounded class="button1 b-color rot-1">#온천</v-btn>
            </v-row>
        </section>
        <v-divider></v-divider>
    </v-container>
</template>

<script>

export default {

}

</script>

<style scoped>


.button1 {
    display: inline-block;
    position: relative;
    border-radius: 3px;
    text-decoration: none;
    padding: .5em;
    margin: .5em;
    font-size: 2em;
    font-weight: bold;
    transition: all .5s;
}

.b-color,
.b-color:before {
    background: linear-gradient(35deg, rgba(0, 0, 0, 0.225) 0%, rgb(225, 225, 225) 100%);
}

.rot-1:hover {
    filter: hue-rotate(130deg);
}

.theme {
    width: 100%;
    margin: 2em;
}

.justify-center {
    margin: 1px;
    padding: 20px;
}

.v-divider {
    margin: 1px;
    padding: 5px;
}

.v-card-title {
    margin-top: 2%;
    margin-bottom: 1%;
    min-width: 300px;
}
.section{
    margin: 2%;
}
</style>