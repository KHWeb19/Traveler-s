<template>
    <footer class="site-footer">
        <div class="container">
            <div class="row">
                <div class="col-sm-12 col-md-6">
                    <h6>사업자 정보</h6>
                    <p>
                        since 2022 어쩌고 저쩌고...우리 회사의 간단한 소개가 적혀있다..
                    </p>
                </div>
                <div class="col-sm-3 col-xs-3 col-md-3">
                    <h6> 고객문의</h6>
                    <p>
                        TEL : 000-000-0000<br>
                        Email : 000000@gmail.com
                    </p>
                </div>
                <div class="col-sm-3 col-xs-3 col-md-3">
                    <h6>SNS</h6>
                    <ul class="footer-links">
                        <a href="https://www.facebook.com/" target="_blank">
                            <img width="30" height="30" src="@/assets/footer/Facebook.png">
                        </a>
                        &nbsp;
                        <a href="https://www.instagram.com/?hl=ko" target="_blank">
                            <img width="30" height="30" src="@/assets/footer/Instagram.png">
                        </a>
                        &nbsp;
                        <a href="https://www.kakaocorp.com/page/service/service/KakaoTalk?lang=ko" target="_blank">
                            <img width="30" height="30" src="@/assets/footer/KakaoTalk.png">
                        </a>
                        &nbsp;
                        <a href="https://youtube.com/?lang=ko" target="_blank">
                            <img width="30" height="30" src="@/assets/footer/youtube.png">
                        </a>
                    </ul>
                </div>
            </div>
            <hr>
        </div>
    </footer>
</template>

<style scoped>
.site-footer {
    background-color: rgb(255, 255, 255);
    padding: 0px;
    font-size: 15px;
    line-height: 25px;
    color: rgb(0, 0, 0);
}

.site-footer hr {
    border-top-color: rgb(0, 0, 0);
    opacity: 0.5;
    size : 100%;
}

.site-footer h6 {
    color: rgb(0, 0, 0);
    font-size: 16px;
    text-transform: uppercase;
    margin-top: 5px;
}

.site-footer h8 {
    color: rgb(0, 0, 0);
    font-size: 13px;
    text-transform: uppercase;
    margin-top: 5px;

}

.footer-links {
    padding-left: 0;
    list-style: none;
    margin-right: 20px;
    margin-bottom: 0px;
}

.footer-links a {
    color: rgb(0, 0, 0);
}

.footer-links li {
    display: block
}

.footer-links.inline li {
    display: inline-block
}
</style>