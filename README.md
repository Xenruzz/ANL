# ANL

        URL url1 = Entity.class.getResource("playerStandDown.png");
        ImageIcon downStand = new ImageIcon(url1);

        URL url2 = Entity.class.getResource("playerDownWalk1.png");
        ImageIcon downWalk1 = new ImageIcon(url2);

        URL url3 = Entity.class.getResource("playerDownWalk2.png");
        ImageIcon downWalk2 = new ImageIcon(url3);

        URL url4 = Entity.class.getResource("playerForwardStand.png");
        ImageIcon upStand = new ImageIcon(url4);

        URL url5 = Entity.class.getResource("playerForwardWalk1.png");
        ImageIcon upWalk1 = new ImageIcon(url5);

        URL url6 = Entity.class.getResource("playerForwardWalk2.png");
        ImageIcon upWalk2 = new ImageIcon(url6);

        URL url7 = Entity.class.getResource("playerLeftStand.png");
        ImageIcon leftStand = new ImageIcon(url7);

        URL url8 = Entity.class.getResource("playerLeftWalk1.png");
        ImageIcon leftWalk1 = new ImageIcon(url8);

        URL url9 = Entity.class.getResource("playerLeftWalk2.png");
        ImageIcon leftWalk2 = new ImageIcon(url9);

        URL url10 = Entity.class.getResource("playerRightStand.png");
        ImageIcon rightStand = new ImageIcon(url10);

        URL url11 = Entity.class.getResource("playerRightWalk1.png");
        ImageIcon rightWalk1 = new ImageIcon(url11);

        URL url12 = Entity.class.getResource("playerRightWalk2.png");
        ImageIcon rightWalk2 = new ImageIcon(url12);
        
        //manually get all the sprites
        //sprites for player down
        sprites[0][0] = downStand.getImage();
        sprites[0][1] = downWalk1.getImage();
        sprites[0][2] = downWalk2.getImage();

        //sprites for player left
        sprites[1][0] = leftStand.getImage();
        sprites[1][1] = leftWalk1.getImage();
        sprites[1][2] = leftWalk2.getImage();

        //sprites for player right
        sprites[2][0] = rightStand.getImage();
        sprites[2][1] = rightWalk1.getImage();
        sprites[2][2] = rightWalk2.getImage();

        //sprites for player up
        sprites[3][0] = upStand.getImage();
        sprites[3][1] = upWalk1.getImage();
        sprites[3][2] = upWalk2.getImage();
