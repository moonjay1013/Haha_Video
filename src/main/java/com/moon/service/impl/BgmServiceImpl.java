package com.moon.service.impl;

import com.moon.dao.BgmDao;
import com.moon.pojo.Bgm;
import com.moon.service.BgmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("BgmService")
public class BgmServiceImpl implements BgmService {
    @Autowired
    private BgmDao bgmDao;
    @Override
    public List<Bgm> findAll() {
        return bgmDao.findAll();
    }

    @Override
    public void addBgm(Bgm bgm) { bgmDao.save(bgm); }

    @Override
    public Bgm getById(Integer id) {
        return bgmDao.getById(id);
    }

    @Override
    public void delBgm(Integer id) {
        Bgm bgm = bgmDao.getById(id);
        bgmDao.delete(bgm);
    }

    @Override
    public void updateBgm(String address, String musicName, String author, Integer id) {
        bgmDao.updateBgmAddress(address, musicName, author, id);
    }
}
