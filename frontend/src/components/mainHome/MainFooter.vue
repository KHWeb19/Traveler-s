<template>
    <v-footer id="footer">
        <v-container id="footcol" fluid>
            <v-divider></v-divider>
            <v-row id="insidefild">
                <v-col cols="12" xs="12" sm="6" md="5">
                    <v-list-item-title id="title">사업자 정보</v-list-item-title>
                    <v-text>
                        since 2022 어쩌고 저쩌고...우리 회사의 간단한 소개가 적혀있다..
                    </v-text>
                </v-col>
                <v-col cols="12" xs="12" sm="6" md="3">
                    <v-list-item-title id="title"> 고객문의</v-list-item-title>
                    <v-text>
                        TEL : 000-000-0000<br>
                        Email : 000000@gmail.com
                    </v-text>
                </v-col>
                <v-col cols="12" xs="12" sm="6" md="3">
                    <v-list-item-title id="title">SNS</v-list-item-title>
                    <v-list-item id="snslink" justify="center">
                        <div id="snsfild" href="https://www.facebook.com/" target="_blank">
                            <img id="snsimg" src="@/assets/footer/Facebook.png">
                        </div>
                        <div id="snsfild" href="https://www.instagram.com/?hl=ko" target="_blank">
                            <img id="snsimg" src="@/assets/footer/Instagram.png">
                        </div>
                        <div id="snsfild"  href="https://www.kakaocorp.com/page/service/service/KakaoTalk?lang=ko" target="_blank">
                            <img id="snsimg" src="@/assets/footer/KakaoTalk.png">
                        </div>
                        <div id="snsfild" href="https://youtube.com/?lang=ko" target="_blank">
                            <img id="snsimg" src="@/assets/footer/youtube.png">
                        </div>
                    </v-list-item>
                </v-col>
            </v-row>
            <v-divider></v-divider>
        </v-container>
    </v-footer>
</template>

<style scoped>

#footer {
    background-color: rgb(255, 255, 255);
    padding: 0px;
    font-size: 15px;
    line-height: 25px;
    color: rgb(0, 0, 0);
}

#footcol {
    justify-content: space-around;
    margin-left: 6%;
    margin-right: 6%;
    margin-top: 0%;
    margin-bottom: 0%;
}

#insidefild {
    justify-content: space-around;
    margin-bottom: 3px;
    margin-top: 5px;
}

#title {
    color: rgb(0, 0, 0);
    font-size: 16px;
    text-transform: uppercase;
    margin-top: 5px;
    justify-content: center;
}

#snslink {
    padding-left: 0;
    margin: 0px;
    padding: 0px;
    width: 200px;
}

#snsfild {
    widows: 45px;
    height: 45px;
    padding: 2px;
    margin: 2px;
}
#snsimg {
    widows: 45px;
    height: 45px;
    max-width: 45px;
    min-width: 45px;
}
</style>