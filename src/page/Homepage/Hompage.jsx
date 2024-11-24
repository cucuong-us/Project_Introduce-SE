import Header from '../../components/Header/Header';
import styles from './Homepage.module.css';
import axios from 'axios';
import { useEffect } from 'react';
function Homepage() {
    useEffect(() => {
        // Gọi API trong useEffect
        axios.get('/api/patients')
            .then(response => {
                console.log('Dữ liệu từ API:', response.data);
            })
            .catch(error => {
                console.error('Lỗi khi gọi API:', error);
            });
    }, []);
    return (
        <div>
            <Header />
            <div className={styles.Home}>
                <div className={styles.overlay}>
                    <h1 className={styles.overlay_h1}>PHÒNG MẠCH TƯ NHÂN</h1>
                </div>
            </div>
        </div>
    );
}

export default Homepage;
