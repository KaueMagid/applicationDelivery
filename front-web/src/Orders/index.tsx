import { useEffect, useState } from 'react';
import { fetchproducts } from './api';
import OrderLocation from './OrderLocation';
import ProductsList from './ProducsList';
import StepsHeader from './StepsHeader';
import './styles.css'; 
import { OrderLocationData, Product } from './types';

function Orders(){
    const [products, setProducts] = useState<Product []>([]);
    const [orderLocation, setOrderLocation] = useState<OrderLocationData>();
    
    useEffect(() => {
        fetchproducts()
        .then(response => setProducts(response.data))
        .catch(error => console.log(error))
    },[])
    
    return(
        <div className="orders-container">
            <StepsHeader/>
            <ProductsList products = {products} />
            <OrderLocation onChangeLocation= {location => setOrderLocation(location)}/>
        </div>
    )
}

export default Orders;