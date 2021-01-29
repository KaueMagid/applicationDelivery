import axios from "axios";
import { Order } from "./types";

const API_URL = 'https://kaue-magid-deliver.herokuapp.com';

export function fetchOrders(){
    return axios(`${API_URL}/orders`)
}

export function confirmDelivery(orderId: number){
    return axios.put(`${API_URL}/orders/${orderId}/delivered`)
}