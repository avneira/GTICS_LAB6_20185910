package com.example.lab6_20185910.repository;

import com.example.lab6_20185910.dto.EquiposPorPaisDto;
import com.example.lab6_20185910.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeviceRepository extends JpaRepository<Device,Integer> {
    @Query(value = "select c.country as country, count(d.deviceid) as cantidadequipos " +
            "FROM country r\n" +
            "inner join site s on (c.countryid = s.siteid)\n" +
            "inner join devicesite ds on (s.siteid = ds.siteid)\n" +
            "inner join devices d on (d.deviceid = ds.deviceid)\n" +
            "gruop by c.countryid\n", nativeQuery = true

    )
    List<EquiposPorPaisDto> obtenerEquiposPorPais();

}


