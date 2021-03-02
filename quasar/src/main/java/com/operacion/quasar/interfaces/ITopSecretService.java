package com.operacion.quasar.interfaces;

import java.util.List;

import com.operacion.quasar.models.Position;
import com.operacion.quasar.models.SatelliteDto;
import com.operacion.quasar.models.SatelliteRequestDto;
import com.operacion.quasar.models.TopSecretResponse;
import com.operacion.quasar.utils.ErrorHandler;

public interface ITopSecretService {
	public TopSecretResponse getTopSecretMessage(SatelliteRequestDto satellites) throws ErrorHandler;
	public TopSecretResponse getSplitTopSecretMessage(List<SatelliteDto> satellites);
	public String getMessage(List<SatelliteDto> satellites) throws ErrorHandler;
	public Position getPosition(List<SatelliteDto> satellites) throws ErrorHandler;
}
