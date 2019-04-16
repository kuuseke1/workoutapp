<template>
    <div class="wrapper">
        <div>
            <Navigation activeTab="Home"/>
            <div class="jumbotron jumbotron-fluid">
                <div class="container">
                    <h1 class="display-4">WELCOME</h1>
                    <p class="lead">Look around and keep track of your accomplishments</p>
                </div>
            </div>
            <br>
            <br>
            <br>
            <div class="hee container text-center">
                <h2>Looking for motivation?</h2>
                <br>
                <div class="row">
                    <div class="col-sm-4">
                        <img src="../assets/mu.jpg" class="icon" alt="">
                    </div>
                    <div class="col-sm-4">
                        <img src="../assets/muu.jpg" class="icon" alt="">
                    </div>
                    <div class="col-sm-4">
                        <img src="../assets/muuu.jpg" class="icon" alt="">
                    </div>
                </div>
            </div>
        </div>
    </div>

</template>

<script>
    import Navigation from '../components/Navigation.vue';

    export default {
        name: "Home",
        components: {
            Navigation
        }
    }
</script>

<style scoped>
    p {
        color: #000;
        font-size: 20px;
        padding: 2px 20px;
    }

    .wrapper {
        height: 100vh;
        margin: auto;
        background-size: cover;
        background: rgb(0, 0, 0);
        background: rgba(0, 0, 0, 0.5) url("../assets/pic.jpg") no-repeat top;
    }
    .jumbotron {
        background-color: rgba(255, 255, 255, 0.52);

    }
    p {
        font-size: 30px;
    }
    h1 {
        font-size: 100px;
    }
    .icon {
        max-width: 250px;
        margin: 1% auto;
        border-radius: 100%;
    }
    h2 {
        color: white;
    }

</style>