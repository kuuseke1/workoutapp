import Vue from 'vue';
import Router from 'vue-router';
import AddExercise from "./views/AddExercise";
import Registration from "./views/Registration";
import LandingPage from "./views/LandingPage";
import Home from "./views/Home";
import Login from "./views/Login";
import Workouts from "./views/Workouts";
import EditWorkout from "./views/EditWorkout";

Vue.use(Router);


export default new Router({
    routes: [
        {
            path: '/',
            name: 'landing',
            component: LandingPage
        },
        {
            path: '/home',
            name: 'Home',
            component: Home
        },
        {
            path: '/addExercise',
            name: 'AddExercise',
            component: AddExercise
        },
        {
            path: '/register',
            component: Registration
        },
        {
            path: '/login',
            name: 'login',
            component: Login
        },
        {
            path: '/workouts',
            name: 'workouts',
            component: Workouts
        },
        {
            path: '/edit',
            name: 'edit',
            component: EditWorkout
        }
    ]
});
