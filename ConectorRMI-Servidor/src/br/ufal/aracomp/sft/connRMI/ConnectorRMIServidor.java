package br.ufal.aracomp.sft.connRMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import br.ufal.aracomp.cosmos.limite.spec.dt.ClienteDT;
import br.ufal.aracomp.cosmos.limite.spec.prov.ILimiteOps;

//Classe que implementa a interface remota

public class ConnectorRMIServidor extends UnicastRemoteObject implements IConnSrv {
	private static final long serialVersionUID = 5534335014110610733L;
	
	private ILimiteOps limiteOps;
	protected ConnectorRMIServidor(ILimiteOps limiteOps) throws RemoteException {
		super();
		this.limiteOps = limiteOps;
	}
	@Override 
	public double calcularLimite(ClienteDTSrv clientSrv) throws RemoteException {
		try {	
			ClienteDT client = new ClienteDT();
			client.salario = clientSrv.salario;
			return this.limiteOps.calcularLimite(client);
		} catch (Exception e) {
			return 0;
		}
	}
}
