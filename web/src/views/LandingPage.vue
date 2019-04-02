<template>
    <div class="wrapper">
        <div>
            <!---<img class="image" src="../assets/logo.png"/>--->
        </div>
        <div class="introduction">
            <h2>Welcome to your Exercise Diary!</h2>
            <h3>Insert exercises and keep track...</h3>
            <RouterLink class="begin-link" to="/login">Let's begin</RouterLink>
        </div>
        <div class="signing">
            <RouterLink class="LButton" to="/login">Log In</RouterLink>
            <RouterLink class="LButton" to="/register">Register</RouterLink>
        </div>
    </div>
</template>
<script>
    export default {
        name: "LandingPage",
    }
</script>
<style scoped>
    .wrapper {
        height: 100vh;
        margin: auto;
        background-size: cover;
        background: #000000 url("../assets/pic.jpg") no-repeat top;
    }
    .introduction {
        text-align: center;
        position: absolute;
        padding: 7%;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        color: #ffffff;
    }
    .begin-link {
        font-size: 50px;
        text-decoration: none;
        background-color: rgba(0, 0, 0, 0.77);
        color: #ffffff;
        padding: 5px 2em 5px 2em;
        border-radius: 100px;
    }
    .begin-link:hover {
        background-color: #000000;
        color: #e6e6e6;
    }
    .LButton {
        margin: 5px;
        border-radius: 15px;
        /* Make the buttons appear below each other  OTHER OPTION display: inline-block;*/
        display: block;
        background-color: rgba(0, 0, 0, 0.77);
        color: #ffffff;
        font-size: 15px;
        /* Button height(vertical) and length(horiz)*/
        padding: 6px 60px;
        text-decoration: none;
        text-align: center;
    }
    .LButton:hover {
        background-color: #e6e6e6;
        color: #000000;
    }
    .LButton:active {
        position: relative;
        top: 1px;
    }
    .signing {
        position: absolute;
        top: 1%;
        right: 1%;
    }
</style>