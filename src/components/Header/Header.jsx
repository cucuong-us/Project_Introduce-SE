import styles from './Header.module.css';
import Menu from '../Menu/Menu';
import { useState } from 'react';

function Header() {
    const [show, setShow] = useState(false);
    return (
        <>
            <div className={styles.nav}>
                <ul className={styles.nav_list}>
                    <div className={styles.nav_item} onClick={() => setShow(!show)}>
                        Menu
                    </div>
                    <div className={styles.nav_item}>Trang chủ</div>
                </ul>
                <ul className={styles.nav_list}>
                    <li>
                        <button className={styles.button}>Đăng xuất</button>
                    </li>
                </ul>
            </div>
            
            <Menu show={show} />
        </>
    );
}

export default Header;
